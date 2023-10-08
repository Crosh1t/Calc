 enum Rome {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), XI(9), X(10);
    private int num;

    Rome(int num) {
        this.num = num;
    }

    public int getValue() {
        return num;
    }

}
