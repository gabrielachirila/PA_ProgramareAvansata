# Lab 2 - Homework
**Firstly**, I created the class that describes an instance of the _problem_, meaning that in that class I have an **array of locations**, 
respectively, an **array of roads**.

Then, for **Location** and **Road** classes, I had to override the **Object.equals** method. Besides that, whenever I try to add a road or a location, 
I **check** if this isn't already in my array of locations/roads, using Object.equals method. 

In **Locatio**n class, instead of using enum for types of locations, I created the following **subclasses**: City, Airport and GasStations which **superclass** 
is Location. For class GasStation I added additional **specific propertes** like gasPrice.

Then, I implemented the **method isValid** to determine if a problem's instance is valid. An instance of the problem is not valid if the length of a road
is less than the euclidian distance between the location coordinates or if I have a road which contains locations that are not in my locations array.

**Finally**, to find out if it is possible to go from one location to another using the given roads, I created a **matrix of locations**, which has 0 and 1 values,
1 is when I have a given road from location(i) to location(j). Then, I used **dfs** to find out if there is a road from source location to destination location.

This is an example of possible output:

<img width="774" alt="image" src="https://user-images.githubusercontent.com/99080710/224163568-fa0365f4-fe68-43d4-bf1d-3bac4f82ff6d.png">
