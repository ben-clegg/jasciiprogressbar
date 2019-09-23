# JAsciiProgressBar

## Installation

- Download jasciiprogressbar.jar from the _Releases_ tab.
- Add the .jar to your classpath or as a dependency in your build configuration.

## Example Usage

In Java applications:

```java
JAsciiProgressBar progressBar = new JAsciiProgressBar(tasks.size());
System.out.println(progressBar);

for (SomeTask t : tasks)
{
    t.run();
    progressBar.incrementProgress();
    System.out.println(progressBar);
}
```

With JVM:

`java -jar jasciiprogressbar.jar <CURRENT COUNT> <END COUNT>`

## Planned Features

- Full JavaDoc
- Release on mvnrepository
- Simple Time Estimation