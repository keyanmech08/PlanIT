# PlanIT

Hi Tehere.....

I have implemented a TestNG based Java project to complete the home test with Page Factory, Reusable components & extended reports. Also i have used maven as a build tool for the CI/CD approach.

In order to run the tests from commandline, we need to go to the project directory and type mvn clean install from command promt. Thanks !

Also please find my below thoughts for each questions.

Questions
1. What other possible scenario’s would you suggest for testing the Jupiter Toys application?
    SCN_001: Login possitive & negative scenarios
    SCN_002: Buy Products after Login
    SCN_003: Updating the Qty in Cart
    SCN_004: Remove items one by one from cart and verify the total & subtotal are getting updated
    SCN_005: Remove All items and verify empty cart is displayed (Click Yes & No from the popup)
    SCN_006: Remove All items and verify empty cart is displayed then start shopping from empty cart
    SCN_006: Complete a successful checkout

2. Jupiter Toys is expected to grow and expand its offering into books, tech, and modern art. We are 
expecting the of tests will grow to a very large number. 
1. What approaches could you used to reduce overall execution time?  ---> Overall time can be reduced by using explicit waits in the reusable components, Running the execution in    parrallel run, Need to use more assertions on the test, Need to free up the driver by quiting after each test cases, avoid thread.sleep, try to re-use the existing browser        instances.
2. How will your framework cater for this? --> I have implemented POM with dynamic xpaths(Buy, Total & SubTotal) , so that we can handle any number of products to add to cart,        more re-usable function & reading data from a file through which we can achieve it.


3. Describe when to use a BDD approach to automation and when NOT to use BDD
    To Use BDD:
    BDD -Behaviour Driven Development can be used when the business, product owners involves in understanding the test cases as BDD will have test scenarios in a simple gherkin       (plain english language). This approach will not need any technical knowledge for any stake holder to read through your scenarios.
    BDD can be used when the user stories are created in an user action wtih given, when then conditions.
    BDD can be used when the end to end flow of an application is typically short and does not have more data dependencies.
    BDD encourages collaboration between business users, developers and testers.
    BDD can be used ,If the project demands any BA, Product Owner & developers to modify the existing tests without having more technical dependencies.
    
    Not To Use BDD:
    Not to use BDD when the requirements are not simple user actions or not created in given, when & then conditions.
    Not to use BDD when application under test has more complex scenarios and functionalitie swhich requires a large number of data to be fed into test.
    Not to use BDD when There needs to be a good amount of communication between the person writing the feature files and the person developing the automation code.
    Not to use BDD when the project runs in a stringent timeline as BDD consumes a more time building the feature files and respective tests.
    Not to be used when the project does not have a scope of maintainability.
    Not to be used when the project demands a hybrid kind of framework.
    Not to be used when the application under test does not follow a sequential functional flow.
    
    
