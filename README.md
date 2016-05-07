README.md. 


Building the solution: 
Download the code using 'git clone git@github.com:ravi-mijar/FlowerShop.git'

I have used Maven as the build tool. 
Use 'mvn -e clean install' to build the source, and run the JUnit tests. 

If running without maven:
Untar the tar file I submitted, and cd to the folder where you untar.
Fire command
On Linux : sh run-tests.sh
On windows : run-tests.bat


Design decisions, and brain dump:

I will attempt to give explanations about my decisions, and list some assumptions I make down the road.
This document is meant to be coarse, and should be more like a daily diary than a published, edited book.

Listed down some test cases that could come up for this problem. 
Next thing I did was try to write the basic algorithm to generate the number of bundles required to fulfill the order. 
I got my first draft working with int arrays and such. Realized I was going the wrong path. This wasn't optimized and was giving 'no solution' answers if bundles didn't fit. I was going with a 'greedy' approach - fit largest bundle size first. switched to a backtracking algorithm, and got correct answers. 

Now I identified the objects, Flowers / Items, Bundles, Orders, Shipments etc. Trying to identify relationships / behaviors between them. 
Bundles have number of pieces, rate, Item. Orders have quantity, item. Shipments will have Bundle-Item combinations.

Now writing tests.

Wondering how to keep track of table(Item, code, size-price of bundle) given in problem statement. 
There could be multiple ways - keep in a file, populate in memory datastructure once at system start.
-Keep it in a static block hardcoded in the java files somewhere.
-Create a rudimentary API to set some in-memory datastructures temporarily. Call this for each test case.
I think I'll go with the API. It gives me some flexibility while writing tests.

I configured SonarQube for the project, and was trying to get the coverage stats. Struggled a bit with the configuration first, but found some online resources. Improved the coverage from about 60% to 88%.

Added a multiple orders test case.

Added log4j configuration and file.

I removed Shipment class I had thought of earlier. It seems unnecessary for the scope.
I have also created a FlowerFactory class that has static factory methods to return the flowers. Feels like a better way than creating these objects everytime in the tests. The constructor of the Item class is present anyway.
Earlier I had tests like validItemCodeInsufficientQuantity, where I was under the impression that there will be a specific amount of inventory for each flower. But, the problem statement imposes no such restriction. So, removing those.

I also didn't keep a separate object for the total price, I feel it is transient in nature, and can be quickly calculated from the Map<Bundle, Integer> being returned.

Renamed Item to Flower. Seems unnecessary to generalize it at this stage. Also removed the FlowerFactory class, and copied the methods and variables over to flower. Made constructor of Flower private.

Added documentation to methods.