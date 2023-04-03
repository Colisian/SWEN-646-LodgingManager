# **SWEN-646-LodgingManager**
**OOP Project: Lodging Manager**

This is a project developed for a graduate-level course in Object-Oriented Programming. The goal of the project was to design and implement a Lodging Manager program using OOP concepts such as inheritance, encapsulation, and polymorphism.

**Project Overview**

The Lodging Manager is a console-based application that allows users to manage a lodging facility's bookings and reservations. The system provides functionality for adding and removing guests, managing room availability, as well as searching and sorting guest information based on different criteria.

**OOP Concepts Used**

**Inheritance:**
Inheritance is used to create a hierarchy of room types. The base class 'ReservationDetail' contains common properties such as reservation number, price, and nights booked, while the derived classes HouseDetail, HotelDetail and CabinDetail add additional properties specific to each type. This allows for more efficient and organized management of room inventory in the lodging facility.

**Encapsulation:**
Encapsulation is used to hide implementation details and ensure that the system is robust and maintainable. All data members are kept private, and access to them is provided through public methods. This ensures that the system is protected from unwanted modifications or misuse.

**Polymorphism:**
Polymorphism is used to enable the system to work with different room types without having to know their specific implementation details. This is achieved through the use of virtual functions in the base class ReservationDetail, such as calculateBasePrice, calculateTotalPrice, and updateReservation, which are overridden in the derived classes HotelDetail, HouseDetail and CabinDetail.

# **Project Structure**

The project is divided into multiple classes, each responsible for a specific aspect of the Lodging Manager program. The main classes are:

- **'Address':**

- **'CustomerAccount':**

- **'HotelDetail':**

- **'HouseDetail':**

- **'CabinDetail':**

- **'ReservationDetail':**

- **'LodgingManager':** 



**Dependencies**

Uses JSON-java:2.3.0 from a Maven Respoistory to format and export text into JSON format.
