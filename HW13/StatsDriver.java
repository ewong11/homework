public class StatsDriver {
    public static void main(String[] args) {
	System.out.println(Stats.mean(4,6));
	System.out.println("------Expected 5-----");
	System.out.println(Stats.mean(0,1));
	System.out.println("------Expected 0-----");
	System.out.println(Stats.mean(4.75,4.25));
	System.out.println("------Expected 4.5-----");
	System.out.println(Stats.max(198, 45));
	System.out.println("------Expected 198-----");
	System.out.println(Stats.max(198, 45,-98));
	System.out.println("------Expected 198-----");
	System.out.println(Stats.max(43.5, 43.45));
	System.out.println("------Expected 43.5-----");
	System.out.println(Stats.max(43.5, 43.45,-13.3));
	System.out.println("------Expected 43.5-----");
	System.out.println(Stats.geoMean(4,4));
	System.out.println("------Expected 4-----");
	System.out.println(Stats.geoMean(4.7, 5.6));
	System.out.println("------Expected 5.130-----");
	System.out.println(Stats.geoMean(4,4,4));
	System.out.println("------Expected 4-----");
	System.out.println(Stats.geoMean(4.0,4.0,4.0));
	System.out.println("------Expected 4.0-----");
	System.out.println(Math.pow(-8, .5));
    }}
