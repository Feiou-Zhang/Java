public final class Test4 {
    class Inner {
        void test() {
            if (Test4.this.flag) {
                sample();
            }
        }
    }
    private boolean flag = true;
    public void sample() {
        System.out.print("s");
    }
    public Test4() {
        (new Inner()).test();
    }
}