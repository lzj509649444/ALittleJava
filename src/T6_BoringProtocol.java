/**
 * Created by lzj on 14-11-6.
 */
public class T6_BoringProtocol {
    class Rem{
        public Pie forBot(Object o) {
            return null;
        }

        public Pie forTop(Object t, Pie r, Object o) {
            return null;
        }
    }
    class Subst{
        public Pie forBot(Object n, Object o) {
            return new Bot();
        }

        public Pie forTop(Object t, Pie r, Object n, Object o) {
            if(o.equals(t))
                return new Top(n,r.subst(n,o));
            else
                return new Top(t,r.subst(n,o));
        }
    }
    abstract class Pie{
        Rem remFn = new Rem();
        Subst substFn = new Subst();
        abstract Pie rem(Object o);
        abstract Pie subst(Object n, Object o);
    }
    class Bot extends Pie{
        @Override
        Pie rem(Object o) {
            return remFn.forBot(o);
        }

        @Override
        Pie subst(Object n, Object o) {
            return substFn.forBot(n,o);
        }
    }

    class Top extends Pie{
        Object t;
        Pie r;

        Top(Object t, Pie r) {
            this.t = t;
            this.r = r;
        }

        @Override
        Pie rem(Object o) {
            return remFn.forTop(t, r, o);
        }

        @Override
        Pie subst(Object n, Object o) {
            return substFn.forTop(t, r, n, o);
        }
    }


    // what is the difference between rem  and subst in Pie?
    // the first one consumes one Object, the second one sonsumes two;

    /*What is the difference between rem and
    subst in the Bot variant?*/

    /*Simple: rem asks for the forBot service from
    remFn and hands over the Object it
            consumes; subst asks for the forBot service
    from substFn and hands over the two Objects
    it consumes.*/


    /*The Sixth Bit of Advice
    When the additional consumed values
    change for a self-referential use of a
    visitor, don't forget to create a new
    visitor.*/

    //interface有什么用， 一般是作为参数， 作为参数有什么用？如果参数不用interface呢？
    //abstract 类也一样
































}
