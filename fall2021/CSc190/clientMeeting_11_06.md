# Client Meeting 11/06/2021

## Meeting with Walt Fehr

Who let the dogs out? Apparently Verma, into his car.

Walt is doing fine.


### Intersection Mapping

### Project Context

- Info to display
  - We can scrap the image display, other intersections don't have it so it'll be useless
  - Will want to interpret the data on app-side
- Scope
  - We are determining scope

- Walt Wants
  - Set up for digest
    - Transmit location and direction
    - Receive state, time to change, and direction'
  - Create live feed from our data streams to the app

- Need Efficient Data Distribution for phase data
- Implementation has been severely over priced compared to the benefit
  - Currently a thought exercise but plans to do real world testing
- All Centered around ITS equipment
  - Some of the equipment has been modernized
    - Others have not been modernized, this is where our project comes in
  - The problem is getting access to the data from the others

#### Data Diode - Key word for cyber security aspect

- Can be plugged into the local network
- Tap into the data
- Transmit this data to a WAN connection
- Originally planned for short range communication methods
  - Allows you to manage the integrity of the system etc
  - Don't want to do anything via internet due to security concerns
- Wants this to be a one-way communication
  - Gets data from traffic light, transmits it to internet
  - Does NOT receive data from internet'

#### Using the Data

- Duplicate output from existing upgraded equipment for older intersections
  - Data streams should be indistinguishable
- Most people don't bother to understand the data and ring and barrier diagrams etc
- Want to create a digest of the data to interpret the data we have
  - This translated data will be sent to other devices later
  - Digest will be told location, direction, and speed
    - Returns the current status of the signal for the specific lane etc
    - Sends back color, movement, and estimated time to change'
  - Interface can be used to test this digest
  - Digest won't be made by us, we are focusing on the data stream
    - Will make a basic digest of the data for the test app
- Verma doesn't know if we should deal with the image feeds on the devices or an edge cloud
- Wants us to populate *current* state of the data type
  - If we can populate anything else, that will be awesome
    - Time to change, etc
      - Would need to interpret traffic data for actuated traffic lights

### Mapping

- College Town Drive would be major street, State University Dr is minor
- Will go over how to actually use tool in a later meeting

### Cyber Security

Use an initial data intergrity setup instead of encryption if possible
