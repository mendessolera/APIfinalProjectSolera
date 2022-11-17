package com.restapi.assessment.ApiAssessment.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.lang.NonNull;

    @Entity
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        private int userID;

        @Column
        private String firstName;

        @Column
        private String lastName;

        @Column
        private String phoneNumber;

        @Column(unique = true)
        @NonNull
        private String email;

        public User() {
        }

        public User(int userID, String firstName, String lastName, String phoneNumber,
                @NonNull String email) {
            this.userID = userID;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public User(String firstName, String lastName, String phoneNumber, @NonNull String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        @NonNull
        public String getEmail() {
            return email;
        }

        public void setEmail(@NonNull String email) {
            this.email = email;
        }
    }

