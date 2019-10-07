# Credit Card Exercise - Presto

This exercise android app implementation handles credit card payments which allows user to input the following card data details:

1. Credit Card Number
2. Expiration Date (in format MM/YY)
3. CVV (the number found on the back of the card)
4. First Name
5. Last Name

Showing a pop-up alert dialog on successful validation of the form after click on submit button.

## Architecture:

Implemented the exercise with **MVVM architecture** (Model-View-ViewModel) to handle the data model, it's flow and business logic across the app.

Have used **Data Binding** library for binding the UI components easily with their data source required in app using declarative format.

* Here all the fields have their own model. 
* There is another model to handle the field's error state.
* The form has it's own model where in the validation logic required for the form completion exists.
* The ViewModel handles the binding of the components and their data source and exposing the fields to the View. 

This MVVM architecture as well as data-binding combination allows to easily handle the code when used individually for different modules across the app.

Utilized the Android's **Material Design** for the UI components look and have standardize feel.

Also used **Leak Canary** library to catch leaks and **Timber** library for better logging.

Have also added **Unit Test Cases** to test the validation required for the form completion and submission.


