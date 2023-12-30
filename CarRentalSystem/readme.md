# Car Rental System

## Followup Questions:
1. Should we make it scalable? <br>
Yes

2. Stick to question only, do not make assumption of adding vehicles by user or something just keep it in scope of renting.




## Objects being used:
1. User
   1. vehicle number
   2. vehicleType(enum: 2 wheeler, 4 wheeler)
2. Location 
   1. Entry time
   2. ParkingSpot
3. Store
   1. findParkingSpace()
   2. updateParkingSpace()
   3. GenerateTicket()
4. Vehicles
   1. id
   2. isEmpty()
   3. Vehicle
   4. Price
   5. Type
5. Reserve
   1. calculateCost()
   2. payment
   3. updateParkingSpot()
6. Bill
7. Payment