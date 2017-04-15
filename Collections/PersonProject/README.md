# PersonProject
### Implements different ways of sorting a collection of Person objects
1. TreeSet with Comparator interface
2. List with Comparator interface
3. Stream with Comparator as functional interface

**Comparator** interface allows us to define ordering conditions on some collection of objects.<br>

1. **Treeset** keeps unique keys and ensures order of elements. The Comparator interface must be implemented.

2. **List** has a method for sorting a collection according to a Comparator class. It is a void method that causes mutation to the original list. To preserve the original list, we'd have to make a copy and then call the sort method.

3. **Stream** returns new instance of ordered collections according to comparison methods defined in the own objects. Avoids [anonymous inner] classes which implement Comparator. 

Comparable vs Comparator interfaces
* Comparable is limited to one comparison method
* Comparator allows more than one comparison method, and so different rules