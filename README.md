**SHORT REFLECTION**

**How do you implement CRUD using SQLite?**

I made a DatabaseHelper class. I used the built-in insert(), update(), and delete()
methods for those operations. To read the notes, I just ran a SELECT * query and 
loaded the results into a list.

**What challenges did face in maitaining data persistence?**

The notes list wouldn't refresh after I added a new one. I fixed it by reloading all
the data from the database in the onResume() method, so it's always fresh when I 
return to the screen.

**How could you improve performance or UI design in future versions?**

First, I'd move all the database stuff to a background thread so it doesn't lag the UI.
And honestly, I'd just use the Room library next time—it handles almost
all of this for you.
