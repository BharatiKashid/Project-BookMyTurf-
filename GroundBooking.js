import React, { useState, useEffect, Fragment } from "react";
import GroundService from "../services/GroundService";
import './GroundBooking.css';


function GroundBooking(props) {
  const initialData = {
    newground: [],
    date: "",
    time: React.createRef(),
    price: "",
    userId: "",
    groundId: "",
  };

  const [data, setData] = useState(initialData);

  // onChange = (e) =>
  //this.setState({ [e.target.name]: e.target.value });

  const onTimeChange = (time, index) => {
    let newground = [...data.newground];
    newground[index].time = time;
    localStorage.setItem("btime", time);
    setData({ ...data, newground });
    console.log(time);
    //console.log(index);
  };

  const onDateChange = (d) => {
    //this.state.newground[index]["bookingTime"]=time;
    localStorage.setItem("bdate", d);
    setData({ ...data, date: d });
    console.log(d);
    //console.log(index);
  };

  const bookNowHandler = (ground, index) => {
    console.log(ground);
    localStorage.setItem("gindex", index);
    console.log(index);

    saveBooking(ground);
    if (data.newground[index].isBooking) {
      window.alert("Ground is booked:" + data.newground[index]["bookingTime"]);

      let newground = [...data.newground];
      newground[index].isBooking = false;
      setData({ ...data, newground });
    } else {
      let newground = [...data.newground];
      newground[index].isBooking = true;
      setData({ ...data, newground });
    }
  };

  useEffect(() => {
    GroundService.getGrounds().then((res) => {
      setData({ ...data, newground: res.data });
    });
  }, []);

  const saveBooking = (u) => {
    let user = {
      groundId: data.newground[localStorage.getItem("gindex")].id,
      date: localStorage.getItem("bdate"),
      time: localStorage.getItem("btime"),
      price: data.newground[localStorage.getItem("gindex")].price,
      userId: parseInt(localStorage.getItem("userw_id"), 10),
    };
    console.log("User => " + JSON.stringify(user));

    GroundService.addGroundBook(user).then((res) => {
      let gh = res.data;
      localStorage.setItem("bid", gh.booking_id);
      console.log(gh.booking_id);
      console.log(" Your ground is booked!");
    });
    props.history.push("/successful");
  };

  return (
    <div className="styleObj1">
      <h2 className="text-center"><span className="styleObj7">Sports Grounds</span></h2>

      <br></br>
     
      <div className="styleObj6">
      <div className="row">
        {
          <table className="table table-striped table-bordered table-hover">
            <thead>
              <tr class="table-info">
                
                <th>Ground Name</th>
                <th>Ground Type</th>
                <th>Location</th>
                <th>Sports</th>
                <th>Contact No</th>
                <th>Rating</th>
                <th>Time Slots</th>
                <th>Date</th>
                <th>Price</th>
                <th>Book Now</th>
              </tr>
            </thead>
            <tbody >
              {data.newground.map((newground, index) => {
                return (
                  <Fragment>
                    <tr  key={newground.id} >
                     
                      <td class="table-danger"> {newground.groundname} </td>
                      <td class="table-warning"> {newground.groundtype}</td>
                      <td class="table-dark"> {newground.location}</td>
                      <td class="table-warning"> {newground.sports}</td>
                      <td class="table-primary"> {newground.contact}</td>
                      <td class="table-primary"> {newground.rating}</td>
                      <td class="table-active">
                        <label for="time"></label>

                        <select
                          name="time"
                          id="time"
                          onChange={(e) => {
                            onTimeChange(e.target.value, index);
                          }}
                        >
                          <option value="9:00-10:00">9:00-10:00</option>
                          <option value="10:00-11:00">10:00-11:00</option>
                          <option value="11:00-12:00">11:00-12:00</option>
                          <option value="12:00-1:00">12:00-1:00</option>
                          <option value="1:00-2:00">1:00-2:00</option>
                          <option value="2:00-3:00">2:00-3:00</option>
                          <option value="3:00-4:00">3:00-4:00</option>
                          <option value="4:00-5:00">4:00-5:00</option>
                          <option value="5:00-6:00">5:00-6:00</option>
                          <option value="6:00-7:00">6:00-7:00</option>
                          <option value="7:00-8:00">7:00-8:00</option>
                        </select>
                      </td>

                      <td>
                        <div
                          style={{
                            margin: "auto",
                            display: "block",
                            width: "fit-content",
                          }}
                        >
                          <label for="date"></label>
                          <input
                            type="date"
                            id="date"
                            name="date"
                            value={data.date}
                            onChange={(e) => {
                              onDateChange(e.target.value);
                            }}
                            min="2022-09-01"
                            max="2023-12-31"
                          />
                        </div>
                      </td>
                      <td class="table-success"> {newground.price}</td>
                      <td >
                        <a
                          href="#"
                          onClick={() => bookNowHandler(newground, index)}
                          className="btn btn-primary  mt-2"
                          style={{ width: "100%" }}
                        >
                          Book Now
                        </a>
                      </td>

                     
                    </tr>
                  </Fragment>
                );
              })}
            </tbody>
          </table>
        }
      </div>
    </div>
    </div>
  );
}

export default GroundBooking;
