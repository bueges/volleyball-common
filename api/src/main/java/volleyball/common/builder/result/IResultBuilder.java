package volleyball.common.builder.result;

import volleyball.common.builder.BuilderException;
import volleyball.common.builder.IBuilder;
import volleyball.common.model.result.IResult;

public interface IResultBuilder extends IBuilder {

    IResultBuilder withResult(String result);

    @Override
    IResult build() throws BuilderException;
}
