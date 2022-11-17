import React from 'react'
import { useEffect, useState } from "react";


import 'bootstrap/dist/css/bootstrap.min.css';


function GetUsers() {
    const [users, setUsers] = useState([]);

    const getData = () => {
        fetch(`http://localhost:8080/api/users`)
            .then(res => res.json())
            .then(users => setUsers(users))
    }

    useEffect(() => {
        getData();
    }, []);



    return (
        <div className="col-8 shadow-lg p-3 text-center rounded" style={{ marginLeft: "auto", marginRight: "auto", marginTop: "10em" }}>
            <h2>LIST OF USERS</h2>
            <table className="table table-striped table-bordered" id="myTable">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Phone Number</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    {users.map((users) =>
                        <tr key={users.userID}>
                            <td>{users.userID}</td>
                            <td>{users.firstName}</td>
                            <td>{users.lastName}</td>
                            <td>{users.phoneNumber}</td>
                            <td>{users.email}</td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    )
}

export default GetUsers