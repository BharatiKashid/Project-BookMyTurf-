import {Link, Routes, Route} from 'react-router-dom';
import AddNewTurf from './AddNewTurf';
import GroundBooking from './GroundBooking';

function UserHome()
{

    return(
        <div>
            <h1> Owner Home </h1>
            <Link to="/groundbook"> Ground BOOK </Link>
        
        <Routes>
            <Route path="/groundbook" element={<GroundBooking />} />
        </Routes>
        </div>
    )
}

export default UserHome;