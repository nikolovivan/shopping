Pricing basket
==============

A small application that allows users to fill a basket with a specific set of items and then
it prints the subtotal, the discounts if any and the final total.

Features
--------

Currently the program supports only one command - `PriceBasket`. The command name is case sensitive and it takes
a list of items that a user wants to add to the basket. The current supported items are the following:

* Apples - price: 1.0 GBP. Discount: 10%.
* Bread - price: 0.80 GBP. No discount.
* Milk - price: 1.30 GBP. No discount.
* Soup - price: 0.65 GBP. No discount.

The item names are not case sensitive. Generally using IDs would be better, but for simplicity we use the name. One can
repeat items as well as many times as they want. We could also have the thing completely dynamic and have the items
configurable using a json file or something similar. Again, for simplicity we have it inside the code.

Project
-------

This is a **Maven** and **Java 1.7** project so generally everything you need is already here. It was tested using **Maven 3**.

Assuming that you have Maven and the right Java installed on your system, it should download all the dependencies for you. Here are some
common operations that you might perform:

1. Compile
  
        mvn compile
        
2. Test

        mvn test
        
3. Package - this will build a fat jar with all required dependencies and a main class already set that you can directly
execute.

        mvn package
        

Running
-------

If you have the fat jar, running the application is pretty straightforward:

    java -jar /path/to/shopping-1.0.0-SNAPSHOT-jar-with-dependencies.jar PriceBasket Item1 Item2 Item3
    
    