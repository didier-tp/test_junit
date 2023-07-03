package tp.other;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IDecorateContract {
	
	static final Logger logger = LoggerFactory.getLogger(IDecorateContract.class);
	
	
	IDecorate create();
	 
    @Test
    default void postcondition() {
        String parameter = "abc"; //or random string
        String res = create().decorate(parameter);
        logger.trace("res="+res);
        assertThat(res).isNotBlank()
                       .contains(parameter);
    }

}
