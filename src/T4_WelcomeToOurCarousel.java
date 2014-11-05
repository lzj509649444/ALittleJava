/**
 * Created by lzj on 14-11-5.
 */
public class T4_WelcomeToOurCarousel {

    // we want all the methods in one class,why?
    // separate the action from the datatype

    /*Because it becomes more and more difficult
    to understand the rationale for each of the
    methods in a variant and what the
    relationship is between methods of the same
    name in the different variants.*/

    /* before
    abstract class Shish{
        abstract boolean onlyOnions();
        abstract boolean isVegetarian();
    }
    class Skewer extends Shish{

        @Override
        boolean onlyOnions() {
            return true;
        }

        @Override
        boolean isVegetarian() {
            return true;
        }
    }

    class Onion extends Shish{
        Shish s;

        Onion(Shish _s){
            s = _s;
        }
        @Override
        boolean onlyOnions() {
            return s.onlyOnions();
        }

        @Override
        boolean isVegetarian() {
            return s.isVegetarian();
        }
    }

    class Lamb extends Shish{
        Shish s;
        Lamb(Shish _s){
            s = _s;
        }
        @Override
        boolean onlyOnions() {
            return false;
        }

        @Override
        boolean isVegetarian() {
            return false;
        }
    }

    class Tomato extends Shish{
        Shish s;
        Tomato(Shish _s){
            s = _s;
        }
        @Override
        boolean onlyOnions() {
            return false;
        }

        @Override
        boolean isVegetarian() {
            return s.isVegetarian();
        }
    }*/


    // visitor
    class OnlyOnions{
        boolean forSkewer(){
            return true;
        }
        boolean forOnion(Shish s){
            return s.onlyOnions();
        }
        boolean forLamb(Shish s){
            return false;
        }
        boolean forTomato(Shish s){
            return false;
        }
    }

    class IsVegetarian{

    }
    abstract class Shish{
        abstract boolean onlyOnions();
        abstract boolean isVegetarian();

        OnlyOnions ooFn = new OnlyOnions();
        IsVegetarian  ivFn = new IsVegetarian();
    }
    class Skewer extends Shish{

        @Override
        boolean onlyOnions() {
            //return true;
            return ooFn.forSkewer();
        }

        @Override
        boolean isVegetarian() {
            return true;
        }
    }

    class Onion extends Shish{
        Shish s;

        Onion(Shish _s){
            s = _s;
        }
        @Override
        boolean onlyOnions() {
            //return s.onlyOnions();
            return ooFn.forOnion(s);
        }

        @Override
        boolean isVegetarian() {
            return s.isVegetarian();
        }
    }

    class Lamb extends Shish{
        Shish s;
        Lamb(Shish _s){
            s = _s;
        }
        @Override
        boolean onlyOnions() {
            //return false;
            return ooFn.forLamb(s);
        }

        @Override
        boolean isVegetarian() {
            return false;
        }
    }

    class Tomato extends Shish{
        Shish s;
        Tomato(Shish _s){
            s = _s;
        }
        @Override
        boolean onlyOnions() {
            //return false;
            return ooFn.forTomato(s);
        }

        @Override
        boolean isVegetarian() {
            return s.isVegetarian();
        }
    }

    // That's why we call this part boring.
    // Ture, it could be done automatically.


    // The Fourth Bit of Advice
    // When writing several functions for same self-referential datatype, use
    // visitor protocols so that all methods for a function can be found in a
    // single class.

    class RemA{
        Pizza forCrust(){
            return new Crust();
        }
        Pizza forCheese(Pizza p){
            return new Cheese(p.remA());
        }
        Pizza forOlive(Pizza p){
            return new Olive(p.remA());
        }
        Pizza forAnchovy(Pizza p){
            return p.remA();
        }
        Pizza forSausage(Pizza p){
            return new Sausage(p.remA());
        }
    }

    class TopAwC{}
    class SubAbC{}
    abstract class Pizza{
        // remove Anchovy
        abstract Pizza remA();
        // top Anchovy with Cheese
        abstract Pizza topAwC();
        // replace Anchovy with cheese
        abstract Pizza subAbC();

        RemA remFn = new RemA();
        TopAwC topFn = new TopAwC();
        SubAbC subFn = new SubAbC();

    }
    class Crust extends Pizza{
        @Override
        Pizza remA() {
            //return new Crust();
            return remFn.forCrust();
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
            /*return new Sausage(
                    p.remA());*/
            return remFn.forSausage(p);
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
            //return p.remA();
            return remFn.forCheese(p);
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
            /*return new Olive(
                    p.remA());*/
            return remFn.forOlive(p);
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
            //return new Crust();
            return remFn.forAnchovy(p);
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































































}
