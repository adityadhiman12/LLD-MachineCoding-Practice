# Parking Lot

## Followup Questions:
1. How many entrances we have? <br>
1 entrance 1 exit but should be scalable that we can add more entrances and exit.


2. Are there any different type of spot? <br>
2 wheeler, 4 wheeler, 3 wheeler


3. Hourly based charge or minute based charge? <br>
Mix of both


4. If there are 2 entrances then I need the parkingSpot nearest to entrance


5. Do we have parking floors? <br>
No
  




## Objects being used:
1. Vehicle
   1. vehicle number
   2. vehicleType(enum: 2 wheeler, 4 wheeler)
2. Ticket 
   1. Entry time
   2. ParkingSpot
3. Entrance Gate
   1. findParkingSpace()
   2. updateParkingSpace()
   3. GenerateTicket()
4. Parking Spot
   1. id
   2. isEmpty()
   3. Vehicle
   4. Price
   5. Type
5. Exit Gate
   1. calculateCost()
   2. payment
   3. updateParkingSpot()