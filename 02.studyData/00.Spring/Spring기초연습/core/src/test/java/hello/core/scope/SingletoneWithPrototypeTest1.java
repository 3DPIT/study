package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import static org.assertj.core.api.Assertions.*;

public class SingletoneWithPrototypeTest1 {

    @Test
    void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototpyeBean.class);
        PrototpyeBean prototpyeBean1 = ac.getBean(PrototpyeBean.class);
        prototpyeBean1.addCount();
        assertThat(prototpyeBean1.getCount()).isEqualTo(1);

        PrototpyeBean prototpyeBean2 = ac.getBean(PrototpyeBean.class);
        prototpyeBean2.addCount();
        assertThat(prototpyeBean2.getCount()).isEqualTo(1);
    }

    @Test
    void singletoneClientUsePrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototpyeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(1);

    }

    @Scope("singleton")
    static class ClientBean{

        @Autowired
        private Provider<PrototpyeBean> prototpyeBeanObjectProvider;
        //private ObjectProvider<PrototpyeBean> prototpyeBeanObjectProvider;// 이전꺼임

        public int logic(){
           PrototpyeBean prototpyeBean = prototpyeBeanObjectProvider.get();
            prototpyeBean.addCount();
            int count = prototpyeBean.getCount();
            return count;
        }
    }


    @Scope("prototype")
    static class PrototpyeBean{
        private int count = 0;

        public void addCount(){
            count++;
        }

        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init = " + this);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototpyeBean.destroy");
        }
    }
}
