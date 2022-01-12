package org.learn.exercise.service;

/**
 * 经纬度转换服务
 */
public class LatLngTransferService {
    private String rawString;
    private String resultString;
    private double doubleNumber;

    /**
     * @param rawString 度分秒格式的字符串
     */
    public LatLngTransferService(String rawString) {
        this.rawString = rawString.trim();
        parser();
    }

    public String getResultString() {
        return resultString;
    }

    public void setResultString(String resultString) {
        this.resultString = resultString;
    }

    private void parser() {
        String[] firstParts = rawString.split("°");
        boolean negative = firstParts[0].contains("-");
        String[] secondParts = firstParts[1].split("'");
        Integer degree = Integer.parseInt(firstParts[0]);
        if (negative) {
            degree = degree * -1;
        }
        Integer minute = Integer.parseInt(secondParts[0]);
        Integer second = Integer.parseInt(secondParts[1].replace("\"", ""));
        this.doubleNumber = degree.doubleValue() + (minute.doubleValue() / 60d) + (second.doubleValue() / 3600d);
        if (negative) {
            this.doubleNumber = this.doubleNumber * -1;
        }
        this.resultString = String.format("%1$.4f", this.doubleNumber);
    }

    @Override
    public String toString() {
        return "LatLngTransferService{" +
                "rawString='" + rawString + '\'' +
                ", resultString='" + resultString + '\'' +
                ", doubleNumber=" + doubleNumber +
                '}';
    }
}
