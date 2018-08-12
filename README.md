# Data Structures and Algorithms
Repository with solutions and analysis of coding problems, which are primarily used for Sofware Engineering / Quant interviews.

The codes here are ones that I practiced for interviews, and I think would be helpful for others as well.

Most of the solutions are in Java with some in Scala, which is helpful for Data Engineers. I do intend to add Python later on and this repo is meant to be a WIP.

If you spot an issue / bug, please create an issue here / or a PR.

### Executing the code
Its easy to notice, the structure is different from the standard Maven/SBT structure, and that is on purpose, to make the choice of language first and then take a look at the code.
To have the environment setup, install the following and use `HelloWorld`

```bash
$ brew cask install java
$ brew install scala sbt
```

Execute `HelloWorld` as follows (package.classname)
```bash
$ sbt "ds-algo-java/runMain helloworld.HelloWorld"  # For Java
$ sbt "ds-algo-scala/runMain helloworld.HelloWorld"  # For Scala
```

Running code from `sbt` shell.
```
$ sbt
sbt:ds-algo> ds-algo-java/runMain helloworld.HelloWorld
sbt:ds-algo> ds-algo-scala/runMain helloworld.HelloWorld
```
If you plan to work with one language specifically, you can set the project in sbt, and then use runMain.
```sbt
sbt:ds-algo> project ds-algo-scala
sbt:ds-algo-scala> runMain helloworld.HelloWorld
```
