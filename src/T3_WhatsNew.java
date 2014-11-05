/**
 * Created by lzj on 14-11-4.
 */
public class T3_WhatsNew {
  /*
    abstract class Pizza{}
    class Crust extends Pizza{}
    class Sausage extends Pizza{
        Pizza p;

        Sausage(Pizza p) {
            this.p = p;
        }
    }

    class Cheese extends Pizza{
        Pizza p;

        Cheese(Pizza p) {
            this.p = p;
        }
    }

    class Olive extends Pizza{
        Pizza p;

        Olive(Pizza p) {
            this.p = p;
        }
    }

    class Anchovy extends Pizza{
        Pizza p;

        Anchovy(Pizza p) {
            this.p = p;
        }
    }

    Pizza pizza =
            new Anchovy(
              new Olive(
                new Anchovy(
                  new Anchovy(
                    new Cheese(
                      new Crust())))));
    // This looks too salty, let remove them;

    Pizza pizza =
            new Anchovy(
                    new Olive(
                            new Anchovy(
                                    new Anchovy(
                                            new Cheese(
                                                    new Crust()))))).remA();*/

    abstract class Pizza{
        // remove Anchovy
        abstract Pizza remA();
        // top Anchovy with Cheese
        abstract Pizza topAwC();
        // replace Anchovy with cheese
        abstract Pizza subAbC();

    }
    class Crust extends Pizza{
        @Override
        Pizza remA() {
            return new Crust();
        }

        @Override
        Pizza topAwC() {
            return new Crust();
        }

        @Override
        Pizza subAbC() {
            return new Crust();
        }
    }
    class Sausage extends Pizza{
        Pizza p;

        Sausage(Pizza p) {
            this.p = p;
        }

        @Override
        Pizza remA() {
            return new Sausage(
                    p.remA());
        }

        @Override
        Pizza topAwC() {
            return new Sausage(
                    p.topAwC());
        }

        @Override
        Pizza subAbC() {
            return new Sausage(
                    p.subAbC());
        }
    }

    class Cheese extends Pizza{
        Pizza p;

        Cheese(Pizza p) {
            this.p = p;
        }

        @Override
        Pizza remA() {
            return p.remA();
        }

        @Override
        Pizza topAwC() {
            return new Cheese(
                    p.topAwC());
        }

        @Override
        Pizza subAbC() {
            return new Cheese(
                    p.subAbC());
        }
    }

    class Olive extends Pizza{
        Pizza p;

        Olive(Pizza p) {
            this.p = p;
        }

        @Override
        Pizza remA() {
            return new Olive(
                    p.remA());
        }

        @Override
        Pizza topAwC() {
            return new Olive(
                    p.topAwC());
        }

        @Override
        Pizza subAbC() {
            return new Olive(
                    p.subAbC());
        }
    }

    class Anchovy extends Pizza{
        Pizza p;

        Anchovy(Pizza p) {
            this.p = p;
        }

        @Override
        Pizza remA() {
            return new Crust();
        }

        @Override
        Pizza topAwC() {
            return new Cheese(
                    new Anchovy(p.topAwC()));
        }

        @Override
        Pizza subAbC() {
            return new Cheese(
                    p.subAbC());
        }
    }

    // The third Bit of Advice
    // when writing a function that returns values of a datatype, use new to create these values;

    // add more Pizza foods

    class Spinach extends Pizza{
        Pizza p;

        Spinach(Pizza p) {
            this.p = p;
        }

        @Override
        Pizza remA() {
            return new Spinach(p.remA());
        }

        @Override
        Pizza topAwC() {
            return new Spinach(p.topAwC());
        }

        @Override
        Pizza subAbC() {
            return new Spinach(p.subAbC());
        }
    }

    // Isn't that neat?
    // Yes, this is a really flexible way of defining
    // classes and methods. Unfortunately. the
    // more things we want to do with Pi~zavs, the
    // more methods we must add.

    // Could it get worse?
    // it sure could. For everything we want to do with Pizza, we must add a method definition to each class

    // why does that become overwhelming?
    /*
    Because it becomes more and more difficult
    to understand the rationale for each of the
    methods in a variant and what the
    relationship is between methods of the same
    name in the different variants.*/


































































}
