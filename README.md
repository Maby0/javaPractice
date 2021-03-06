## Product Scanner exercise

Hopefully you have worked your way through the [Learning Objectives](https://www.notion.so/kinandcarta/2bebd563189f4a5bb7efb1529474a86f?v=d44afb13070f4647984a88b8370689ba)
resources in Notion.  Towards the end of the 'Hello Java!' there is a coding exercise.
This project will actually help you implement that exercise, starting pretty much
from scratch for people who are new to Java or need a refresher.

We will assume here that you have Intellij installed and running on your computer
(please see the 'Set up your environment!' section in Notion if not).

### Create your Intellij project

A skeleton version of the project has been set up on Github at `git@github.com:markschnitzius/ProductScannerExercise.git`.
So you can create the project by selecting "File | New | Project from Version Control":

![New Project from Version Control](doc/createproj.png)

And paste in the github URL:

![Get from Version Control](doc/getfromversioncontrol.png)

You'll need to also give it the directory where you want to save the project locally.
After clicking Clone, you should be able to view the project structure in the Project
view pane on the left.  Click around and have a look:

![Project pane](doc/projectpane.png)

If you see red anywhere in the Project pane or in the files themselves, it means
something hasn't been configured properly.  Most likely it means you haven't
installed Java, or Intellij doesn't know where it is.  We won't go into all the
possible configuration problems here; it's probably best to asked for help if you're
seeing these errors.

### Maven

This project uses a build automation tool called Maven that is widely used for project management.
(Kin+Carta use it, but sometimes also use an alternative called Gradle.)  Using Maven, you can

* Configure the project Java version, project structure, properties, etc.
* Define which external libraries are used by the project.
* Set up tasks to execute the code, run tests, etc.

Maven is configured by placing a pom.xml file at the top level of the project.  Have a look
at the one that's included, and special Maven panel that Intellij provides when it sees that
your project uses Maven:

![Maven](doc/maven.png)

### The first exercise

For the first exercise, the goal is just to get the included unit test to pass!  Let's have
a look at the test file.  Select it in the left hierarchy:

You might notice that the 'package' statement at the top of the file matches the last part
of the file's directory hierarchy:

![Packages](doc/packages.png)

This is not a coincidence.  Java uses this packaging as namespacing, so that you can have
classes of the same name as long as they live in different packages (directories), and the
package defined for a class must always match that directory hierarchy.

#### Debugging the test

In Intellij you can either 'run' or 'debug' test classes.  Running them means they will
run straight through without stopping; debugging them means they will stop at any breakpoints
you define and let you look closer.  Debugging may be marginally slower, but in general it
never hurts to just use the debug option always, even if you haven't defined any breakpoints.

Intellij provides lots of ways that you can debug the test.  You can

* use the Maven panel to execute the "Lifecycle | test" target (right click it and select 'Debug...')
* right click on any package in the Project view and select 'Debug...', which will debug all tests under that package
* click the green double-arrow beside the test class name in the file view and select 'Debug...'
* click the green single arrow beside the test method name and select 'Debug...'

Let's do that last option:

![Debug method](doc/debugtestmethod.png)

It may take a moment to compile and execute the test (watch the status bar at the very bottom of the
Intellij window).  But then you should see a test failure:

![Test failure](doc/testfailure.png)

This failure occurs because we've only stubbed out the class that's being tested (CheckoutImpl).  Your job is to
add the 'guts' to that class, so that this test will pass!

### A word about currency values

In this test project we are representing the currency amounts in a Java primitive type, int, representing the
number of pence.  This is not an uncommon approach, to represent currency amounts as a raw count of the smallest
unit; however, it is prone to error in situations where percentages or conversions may occur, as there is no way
to represent a fraction of a pence.

However, using one of Java's floating point types (float, double, or BigDecimal) is also prone to error, and
you'll often see cases where values that should compute to a whole value like 8 instead compute to 7.9999.

So what's the solution?  In production-ready systems where it is frequently important to maintain a high degree
of accuracy for our clients, it is recommended that you do not reinvent the wheel -- instead use an existing
library such as [javax.currency](https://www.baeldung.com/java-money-and-currency) to represent your currency
amounts.  This library contains battle-tested classes and methods you can use to parse currency amounts,
round accurately, convert between currencies, etc. with a high degree of confidence.

### Bonus points

If you've gotten the test running, well done!  But if that was a bit too easy, here are a few enhancements you
might want to consider:

* We hardcoded the list of available products in CheckoutImpl.  Make it instead so that these are defined by the code which creates instances of this class -- either pass them in via a constructor, or by additional method calls.
* Checkout is a Java interface, but its implementation is a Java class.  We could also define an interface for the Item class -- this would allow us to define other kinds of items in the future with additional fields.
* The CheckoutImpl#getTotal method computes the total each time you call it.  Make it save the total to a new field the first time, then just return that field every time it is called afterwards.
* Did you compute the total using a 'for' loop?  An alternative is to do it using a functional programming technique built into modern day Java.  See [Java Streams](https://stackify.com/streams-guide-java-8/) for more information.

## Next steps

You should at this point be able to add the next bit of new functionality to the CheckoutImpl class.  The
exercise description talks about also applying specific promotions.

Start by uncommenting the additional test methods, and seeing that they fail because promotions aren't being applied.
(Incidentally, this method of writing failing tests before proceeding with code is known as [Test-Driven Development](https://en.wikipedia.org/wiki/Test-driven_development).)

As there are two kinds of promotion, you'll probably want to define an interface that all promotions must
implement, and then two classes that implement that interface for the two different promotion types.
Then you'll need to apply these promotions when you compute the total.