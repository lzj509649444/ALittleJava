/**
 * Created by lzj on 14-11-5.
 */
public class T5_ObjectArePeopleToo {

    class RemA{
        public Pie forBot() {
            return new Bot();
        }

        public Pie forTop(Object t, Pie r) {
            if(t instanceof Anchovy)
                return r.remA();
            else
                return new Top(t,r.remA());
        }
    }
    class RemFish{
        public Pie forBot(Fish f) {
            return new Bot();
        }

        public Pie forTop(Object t, Pie r, Fish f) {
            if(f.equals(t))
                return r.remFish(f);
            else
                return new Top(t,r.remFish(f));
        }
    }
    abstract class Pie{
        RemA raFn = new RemA();
        abstract Pie remA();

        RemFish rfFn = new RemFish();
        abstract Pie remFish(Fish f);

        Rem remFn = new Rem();
        abstract Pie rem(Object o);
    }
    class Bot extends Pie{
        @Override
        Pie remA() {
            return raFn.forBot();
        }

        @Override
        Pie remFish(Fish f) {
            return rfFn.forBot(f);
        }

        @Override
        Pie rem(Object o) {
            return remFn.forBot(o);
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
        Pie remA() {
            return raFn.forTop(t,r);
        }

        @Override
        Pie remFish(Fish f) {

            return rfFn.forTop(t,r,f);
        }

        @Override
        Pie rem(Object o) {
            return remFn.forTop(t,r,o);
        }
    }

    abstract class Fish{}
    class Anchovy extends Fish{
        public boolean equals(Object o){
            return (o instanceof Anchovy);
        }
    }
    class Salmon extends Fish{
        public boolean equals(Object o){
            return (o instanceof Salmon);
        }
    }
    class Tuna extends Fish{
        public boolean equals(Object o){
            return (o instanceof Tuna);
        }
    }

    Pie pie = new Top(new Anchovy(),
                 new Top(new Tuna(),
                    new Top(new Anchovy(),
                            new Bot())));




    // why not RemFish and RemA and RemInt?
    // They are unnecessary once we hava Rem

    class Rem{
        Pie forBot(Object o){
            return new Bot();
        }
        Pie forTop(Object t, Pie r, Object o){
            if(o.equals(t))
                return r.remA();
            else
                return new Top(t,r.rem(o));
        }
    }


















































}
