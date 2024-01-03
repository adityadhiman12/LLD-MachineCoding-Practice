# BookMyShow with concurrency

## Objects
1. User
2. Movie
3. City
4. Threatre
5. Screen
6. Shows
7. Seats
8. Booking
9. Payment

## Concurrency
1. 1 seat shouldn't be given to both users.
2. if user1 selected a seat then a seat should be booked for 10 mins<br>
we can use redis to cover the lock and release it automatic within 10 mins.

There comes lock:
1. Optimistic: It allows multiple user to do the read and it maintain versions and now suppose if user1 is reading and
want to take the seat then it will check if version is 1 only(that means no other person has changed it) then it will lock it and also change it version to v2 and then release the lock.
Now suppose if user2 wants to book a seat then it checks that if the version is still same as it was previously working on i.e. version1 and as it is not then it will fail to acquire the lock
and ask to read again so that it can get the latest version.
2. Pessimistic: Whenever reading, lock it there and then and when later it is updating then it will release the lock.

### Now question is which lock to choose?
Now as we are going through all the seats in the show and if we are just going through then we need not lock it as that will not work well in case of multiple people trying to book,
hence we should go for Optimistic locking here.