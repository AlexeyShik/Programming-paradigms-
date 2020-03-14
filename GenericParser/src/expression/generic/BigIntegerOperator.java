package expression.generic;

import expression.exceptions.DivideByZeroException;
import org.jetbrains.annotations.NotNull;
import java.math.BigInteger;

public class BigIntegerOperator extends AbstractOperator<BigInteger> {
    public BigIntegerOperator(boolean flag) {
        needCheckExceptions = flag;
    }

    @Override
    public BigInteger parseNumber(String number) {
        return super.parseNumber(number, BigInteger::new);
    }

    @Override
    public BigInteger add(@NotNull BigInteger left, BigInteger right) {
        return super.binary(left, right, BigInteger::add);
    }

    @Override
    public BigInteger subtract(@NotNull BigInteger left, BigInteger right) {
        return super.binary(left, right, BigInteger::subtract);
    }

    @Override
    public BigInteger multiply(@NotNull BigInteger left, BigInteger right) {
        return super.binary(left, right, BigInteger::multiply);
    }

    @Override
    public BigInteger divide(BigInteger left, @NotNull BigInteger right) {
        if (right.equals(new BigInteger("0"))) {
            throw new DivideByZeroException("Divide", left + "/" + right);
        }
        return super.binary(left, right, BigInteger::divide);
    }

    @Override
    public BigInteger negate(@NotNull BigInteger x) {
        return super.unary(x, BigInteger::negate);
    }

    @Override
    public BigInteger count(@NotNull BigInteger x) {
        return super.unary(x, y -> BigInteger.valueOf(y.bitCount()));
    }

    @Override
    public BigInteger min(@NotNull BigInteger left, BigInteger right) {
        return super.binary(left, right, BigInteger::min);
    }

    @Override
    public BigInteger max(@NotNull BigInteger left, BigInteger right) {
        return super.binary(left, right, BigInteger::max);
    }
}
