package summarizator;

import org.springframework.stereotype.Service;

@Service
public class Summarize implements SummarizeNumbers {

    @Override
    public Integer sum(Integer a, Integer b) {
        if(a == null || b == null) {
            throw new IllegalStateException("cannot run on null objects");
        } else if (a > Integer.MAX_VALUE ||  a < Integer.MIN_VALUE) {
            throw new IllegalStateException("Please use Integers within range of "
                    + Integer.MIN_VALUE +" and " + Integer.MAX_VALUE);
        } else if (b > Integer.MAX_VALUE ||  b < Integer.MIN_VALUE) {
            throw new IllegalStateException("Please use Integers within range of "
                    + Integer.MIN_VALUE + " and " + Integer.MAX_VALUE);
        }
        // Also we need to cover overflow of values, therefore additional checks should be implemented
        return a+b;
    }
//
//    @Override
//    public Double sum(Double a, Double b) {
//        if(a == null || b == null) {
//            throw new IllegalStateException("cannot run on null objects");
//        }
//        else if (a > Double.MAX_VALUE ||  a < Double.MIN_VALUE) {
//            throw new IllegalStateException("Please use Integers within range of "
//                    + Double.MIN_VALUE +" and " + Double.MAX_VALUE);
//        } else if (b > Double.MAX_VALUE ||  b < Double.MIN_VALUE) {
//            throw new IllegalStateException("Please use Integers within range of "
//                    + Double.MIN_VALUE + " and " + Double.MAX_VALUE);
//        }
//        return a+b;
//    }
}
