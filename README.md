# shopping-cart
simple implementation of spring boot for shopping cart for variable discount implementation

# Question 1

In Order to Answer Question no 1. The simple logic is split text by &quot;\n&quot; and then store to string

And then we need to find a &quot;;&quot; and split with that mark and store to new Map.

Time complexity for this algorithm is E x N, E means Enter and N means Semicolon in a text String

# Question 2

To Answer Question No 2. I combine Breadth First Traversal and Depth First Traversal to collect all possible path in Graph. Then I Remove all duplicate path via LinkedHashSet. And Then just simply sum and compare all weight for every path in the list

# Question 3

To handle the problem in the question 3. I Used Discount Strategy for Each Customer.

Customer can be Employee, Affiliate or Regular Customer. To Handle this things, I Declare Regular Customer as Parent Class of Employee and Affiliate.

In The Other Hand the implementation of Discount declare on Discount Interface. So for each class will implement getDiscount() method, even the superclass. The subclass only overridden

# Test
To test Q1 and Q2 i already add simply unit test via junit for each question
To test Q3 i seperataly test by each package:
- @WebMvcTest for Controller
- @DataJpaTest for Repository
- @Test Unit Test for Service
- @SpringBootTest for Integration Test
