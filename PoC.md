# Cookie on Demand - Proof of Concept

  - Author: Sebastien Mosser ([mosser@i3s.unice.fr](mosser@i3s.unice.fr))
  - Reviewers: Philippe Collet, Quentin Cornevin, Etienne Strobbe
  - Version: 1.0 (Jan 16)
  
## Specifications

The implementation of the _Cookie on Demand by The Cookie Factory_ system has already started. It implements the 6 following user stories. We consider a persona named _Carter_, who is a given customer of The Cookie Factory.

  1. As a customer, I want to consult the product catalogue so that I can list the pre-made recipes
  2. As Carter, I want to select an item to order so that I can order it
  3. As Carter, I want to select multiple items so that I can make a composite order
  4. As Carter, I want to add cookies at anytime so that I do not have to remember the contents of my cart
  5. As Carter, I want to remove cookies from my cart so that I become less fat at the end
  6. As Carter, I want to send my cart to the system so that I'll pick up my cookies at some point

It corresponds to the beginning of an epic dedicated to cookie ordering using the system. For each story, its _definition of done_ is implemented using the Cucumber framework. See [order.feature](src/test/resources/order.feature)

