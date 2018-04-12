# List Partitioner

## Description
List partitioner is an utility to subdivide a list to a list of list having each one the same size (the final list may be smaller) for a given partition size

| List       | Partition size           | Result  |
| ------------- |:-------------:| -----:|
| [1,2,3,4,5,6,7,8]     | 8 | [[1,2,3,4,5,6,7,8]]
| [1,2,3,4,5,6,7,8]     | 3 | [[1,2,3],[4,5,6],[7,8]
| [1,2,3,4,5,6,7,8]     | 2 | [[[1,2],[3,4],[5,6],[7,8]]

## Example
```java
import com.adneom.listpartitioner.ListPartioner;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> toBePartitioned = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(ListPartioner.partition(toBePartitioned, 8));
        System.out.println(ListPartioner.partition(toBePartitioned, 3));
        System.out.println(ListPartioner.partition(toBePartitioned, 2));
    }
}

```
**Output**
```
[[1, 2, 3, 4, 5, 6, 7, 8]]
[[1, 2, 3], [4, 5, 6], [7, 8]]
[[1, 2], [3, 4], [5, 6], [7, 8]]
```

## Importing the library to your project

To use the partitioner you need to  add this dependency to your project with the appropriate version
```
        <dependency>
            <groupId>com.adneom.listpartitioner</groupId>
            <artifactId>list-partitioner</artifactId>
        </dependency>
```