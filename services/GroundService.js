import axios from "axios";

const GROUND_BOOKING_REST_URL="http://localhost:8080/ground";
const GROUNDId_BOOKING_REST_URL="http://localhost:8080/ground/getBid?date="+localStorage.getItem("bdate")+"&time="+localStorage.getItem("btime");
const AddGROUND_BOOKING_REST_URL="http://localhost:8080/ground/addbook";

class GroundService{

    getGrounds(){
        return axios.get(GROUND_BOOKING_REST_URL+"/get");
    }

    addGroundBook(book){
        return axios.post(AddGROUND_BOOKING_REST_URL,book);
    }

    getBookId(){
        return axios.get(GROUNDId_BOOKING_REST_URL);
    }

    getAll(){
        return axios.get(GROUND_BOOKING_REST_URL+"/getAllBookings");
    }

}
export default new GroundService();