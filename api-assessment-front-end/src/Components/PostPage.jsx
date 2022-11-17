import React from 'react'
import { useState } from 'react'
import './postpage.css'

import 'bootstrap/dist/css/bootstrap.min.css';

const PostPage = () => {

  const [formValues, setFormValues] = useState({});

  const handleInputChange = (e) => {

    const { name, value } = e.target;
    console.log("handle", name, value);
    setFormValues({ ...formValues, [name]: value });
  }

  function refreshPage() {
    window.location.reload(false);
  } 

  const handleSubmit = (e) => {
    e.preventDefault();

    const formData = new FormData(e.target);

    const data = Object.fromEntries(formData)

    const requestOptions = {
      method: 'POST',
      headers: {
        'Content-type': 'application/json'
      },
      body: JSON.stringify(data)
    }

    const url = "http://localhost:8080/api/users";
    fetch(url, requestOptions)
      .then(console.log("post"))
      .then(alert("USER CREATED SUCCESSFULLY"))
      .catch(error => console.log(error));


  };

  return (
    <div className="col-6 mt-4 mb-4 shadow-lg p-3 text-center rounded" style={{ marginLeft: "auto", marginRight: "auto", marginTop: "10em" }}>
      <form className="form-group" onSubmit={handleSubmit}>
        <h2>ADD NEW USER</h2>
        <div>
          <input type="text" name="email" className="form-control" placeholder="Email" onChange={handleInputChange} value={formValues.email || ''} />
        </div>
        <div>
          <input type="text" name="firstName" className="form-control" placeholder="First Name" onChange={handleInputChange} value={formValues.firstName || ''} />
        </div>
        <div>
          <input type="text" name="lastName" className="form-control" placeholder="Last Name" onChange={handleInputChange} value={formValues.lastName || ''} />
        </div>
        <div>
          <input type="number" name="phoneNumber" className="form-control" placeholder='Phone Number' value={formValues.phoneNumber} />
        </div>

        <div>

        </div>
        <button type="submit" className="btn btn-primary" onClick={refreshPage}>Submit</button>

      </form>
    </div>
  )
}

export default PostPage