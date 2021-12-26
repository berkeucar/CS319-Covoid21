# CS319 - Group Project - Fall 2021/2022

## Group3E - Covoid-21 - Pandemic Manager

## General Information
This software project is an application which helps universities to manage their pandemic related issues and processes.

## Build Guide

Backend:
1. Fork/clone this project from GitHub into your local machine.
2. Open the project folder using IntelliJ Ultimate 2021 (which should be free to obtain with an educational e-mail).
3. Check the project SDK from File -> Project Structure -> SDK and make sure it is Amazon Corretto version 11.0.13. If it is something else, you can download it from
   Project Structure -> Platform Settings -> SDKs -> Add new ("+" button) -> Download JDK -> Version 11 and Vendor Amazon Corretto (11.0.13), then set the project SDK
   to that.
4. If there's no build configuration, select Run -> Edit Configurations -> Add new ("+" button) -> Under "Build and run," select the Amazon Corretto 11.0.13 SDK, select
   com.covoid21.panman.PanmanApplication for the main class, and select "@argfile (Java 9+)" for the "Shorten command line" option.
5. The application should now be buildable and runnable. If you would like, you may open com.covoid21.panman.PanmanApplication and experiment with various services' operations
   inside the "commandLineRunner" method. Some (mostly commented out) example code is available as examples on how to use the services. If you want to use another service,
   make sure to add it as a parameter of the "commandLineRunner" method.

## Planned Features
- Vaccination Status Tracking
- Test Appointment System
- Infected/Contacted Status using Hayat Eve Sığar (HES) API
- Seating Plans and Status of Your Contacts
- Heat (Risk Status) Map of Buildings and Classrooms
- Information Center about University and Government's Pandemic Policies
- Nearby Vaccination Center Information
- Notifications about the Risks that You Encounter (such as contact being infected)
- Dormitory Infection Tracking for Nearby Rooms or Common Restrooms in Dorms
- Infection tracking of the people who use campus facilities like gym, pool, closed squash court etc. at the same time
- Infection tracking of the people who use shuttles.

## Aim
- To reduce the health risks due to the face-to-face teaching in pandemic.
- To provide easy-to-access information about the situation of the pandemic at the campus.
- To make people around the campus to take the vaccine or give a test.
- To make pandemic more manageable for both students and university administration.

## User Types
- Administration User: This user type will be granted to university staff such as dormitory admins and the rector.
- Student User
- Instructor User
- Health Center User: This user type can be applied to the doctors, nurses, urgent aid workers and information center workers (mentioned in planned features).

## General Features for All Users
- There will be a part of the system that ask users to enter their roommates, officemates or close classmates to track infection status.
- If they are detected as contacted, they will receive immediate notifications and will be asked to give a test which is negative after 2 days of contact.
- If they are not vaccinated fully, they will be asked to give tests with 3 days intervals with notifications.
- They can make an appointment optionally or due to their contact status.
- They can make appointments for the health center, test center or facilities of gym, pool etc. which provides the application to track the infection flow around the other facilities.

## Student Users' Functionalities
- For each classroom they have been, there will be a screen for selecting the seat they have been sitting.
- They will be attached with their dormitory roommates, if they have any.

## Instructor Users' Functionalities
- For each of their office mates will be asked from instructors as well as their classrooms.
- They will obtain a notification if somebody in their class happens to be infected but not nearby them in order them to not accept the student to the class.

## Health Center Users' Functionalities
- Their office mates' infection status will be asked and tracked.
- They can put an entry to the information system about the infection.

## Administration Users' Functionalities
- They can edit their Pandemic Policy information.
- They can change the appointment quota and time intervals of their facilities.

## Maintenance Users' Functionalities
- They manipulate everything that is listed above, however at the end they will have to give a report and log of the system to the rector or someone who is in charge.

#### Group Members
- Kutay Demiray
- Gökberk Keskinkılıç
- Berke Uçar
- Yağız Yaşar
- Ömer Burak Yıldıran

****
**Instructor:** Eray Tüzün
****
