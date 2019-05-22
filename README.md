  # Triggerise BE Challenge

Besides providing exceptional rewards for good behaviours, Triggerise also runs a physical store which sells (only) 3 products:

```
Code         | Name                   |  Price
-------------------------------------------------
TICKET       | Triggerise Ticket      |   5.00€
HOODIE       | Triggerise Hoodie      |  20.00€
HAT          | Triggierse Hat         |   7.50€
```

Various departments have insisted on the following discounts:

 * The marketing department believes in 2-for-1 promotions (take two of the same product, one of them is free), and would like for there to be a 2-for-1 special on `TICKET` items.

 * The CFO insists that the best way to increase sales is with discounts on bulk purchases (buying x or more of a product, the price of that product is reduced), and demands that if you buy 3 or more `HOODIE` items, the price per unit should be 19.00€.

Triggerise's checkout process allows for items to be scanned in any order, and should return the total amount to be paid. The interface for the checkout process looks like this (Scala):

```Scala
val co = Checkout(pricing_rules)
co.scan("TICKET")
co.scan("TICKET")
co.scan("HOODIE")
val price = co.total
```

Using preferably Scala or Java implement a checkout process that fulfills the requirements.

If you want to implement in something else, please let us know beforehand.

### Examples

```
Items: TICKET, HOODIE, HAT
Total: 32.50€
```

```
Items: TICKET, HOODIE, TICKET
Total: 25.00€
```

```
Items: HOODIE, HOODIE, HOODIE, TICKET, HOODIE
Total: 81.00€
```

```
Items: TICKET, HOODIE, TICKET, TICKET, HAT, HOODIE, HOODIE
Total: 74.50€
```

### Delivery

**Keep in mind that**:
  - The code should be written as production-ready code. You will write production code if you work at Triggerise;
  - The code should be easy to grow and easy to add new functionality;
  - Tests (Unit, UI, ...) should be present yet the level or the type of testing is up to you. Do whatever gives you confidence in your features;
  - Using any framework while solving the challenge is neither seen as positive nor negative. However keep in mind that the challenge can be solved using any "vanilla" language and plain old <insert language here> objects. If you wish to use a framework, feel free to do so but be ready to justify it.

After analyzing your solution, the team can decide to proceed to a technical interview to discuss your implementation decisions.

The preferred method of delivery is by sending us a public GitHub repository with your application but you can also send us a `.zip` file if you prefer.


Solution

------------------------------------------
|  Main Menu                             |
|  [1] Show Product                      |
|  [2] Check-Out                         |
|  [0] Exit                              |
------------------------------------------
Choose your option:2

Menu Check Out
------------------------------------------
[1] TICKET
[2] HOODIE
[3] HAT
[0] FINISH
Choose your option:1
Quantity:3
Save!

Menu Check Out
------------------------------------------
[1] TICKET
[2] HOODIE
[3] HAT
[0] FINISH
Choose your option:2
Quantity:3
Save!

Menu Check Out
------------------------------------------
[1] TICKET
[2] HOODIE
[3] HAT
[0] FINISH
Choose your option:0

=================== CHECK-OUT ===================
Product: HOODIE - Quantity: 3 - Price: 57.0
Product: TICKET - Quantity: 3 - Price: 10.0
------------------------------------------
Total: 67.0

Run:
java -jar triggerise-1.0-SNAPSHOT.jar
