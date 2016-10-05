# Running Play! as a lib

Different ways to run a Play! app.

## Run as a library

Run as a library as part of a larger application.  We're responsible for
defining the `ServerConfig`.  Much of the rest of the Play! framework
functions are unavailable.  Read more about this method in the docs:

https://www.playframework.com/documentation/2.5.x/ScalaEmbeddingPlay

To run:

`sbt "runMain seglo.BootStandalone"`

## Run with a standard directory structure

By default the Play! sbt plugin uses a non-standard scala directory
structure.  You can disable this and restructure your project in a way
that you prefer, but still run the project as a Play! app.  This feature
is experimental.

https://www.playframework.com/documentation/2.5.x/Anatomy#Default-SBT-layout

To run:

`sbt run`
