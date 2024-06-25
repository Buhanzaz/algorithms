package com.buhanzaz.my_api;

public final class Matrix {
    public static double dot(double[] x, double[] y) {
        //TODO Скалярное произведение векторов
        if (x == null || y == null || x.length != y.length) {
            throw new ArithmeticException();
        }

        double result = 0;

        for (int i = 0; i < x.length; i++) {
            result = x[i] * y[i];
        }

        return result;
    }

    public static double[][] multiply(double[][] x, double[][] y) {
        //TODO Произведение двух матриц
        if (x == null || y == null || x.length != y.length || x[0].length != y.length) {
            throw new ArithmeticException();
        }

        double[][] result = new double[x.length][y[0].length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                for (int k = 0; k < x[0].length; k++) {
                    result[i][j] += x[i][k] * y[k][j];
                }
            }
        }

        return result;
    }

    public static double[][] transpose(double[][] x) {
        //TODO Транспонирование
        if (x == null || x.length == 0 || x[0].length == 0) {
            throw new ArithmeticException();
        }

        double[][] result = new double[x[0].length][x.length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                result[j][i] = x[i][j];
            }
        }

        return result;
    }

    public static double[] multiply(double[][] x, double[] y) {
        //TODO Произведение матрицы на вектор
        if (x == null || y == null || x.length != y.length || x[0].length != y.length) {
            throw new ArithmeticException();
        }

        double[] result = new double[x[0].length];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                result[i] += x[i][j] * y[j];
            }
        }

        return result;
    }

    public static double[] multiply(double[] x, double[][] y) {
        //TODO Произведение вектора на матрицу
        if (x == null || y == null || x.length != y.length || x.length != y[0].length) {
            throw new ArithmeticException();
        }

        double[] result = new double[x.length];

        for (int i = 0; i < y[0].length; i++) {
            for (int j = 0; j < x.length; j++) {
                result[i] += y[j][i] * x[j];
            }
        }
        return result;
    }
}
