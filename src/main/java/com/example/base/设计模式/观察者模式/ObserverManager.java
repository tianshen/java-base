package com.example.base.设计模式.观察者模式;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

@Slf4j
public class ObserverManager implements Observerable<ObserverBean> {

    private List<Observer<ObserverBean>> observerList = Lists.newArrayList();

    @Override
    public void registerObserver(Observer<ObserverBean> o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer<ObserverBean> o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObserver(ObserverBean t) {
        if (!CollectionUtils.isEmpty(observerList)) {
            for (Observer observer : observerList) {
                observer.update(t);
            }
        }
    }

    @Override
    public void sortObserver(final Class annotationType) {
        Collections.sort(observerList, (o1, o2) -> {
            Annotation annotation1 = o1.getClass().getAnnotation(annotationType);
            Annotation annotation2 = o2.getClass().getAnnotation(annotationType);

            Integer order1 = 0, order2 = 0;
            try {
                Method method = annotationType.getMethod("order");
                order1 = (Integer) method.invoke(annotation1);
                order2 = (Integer) method.invoke(annotation2);
            } catch (Exception e) {
                log.error("method.invoke is error", e);
            }

            log.info("order1 = {},order2 = {}", order1, order2);

            return order1 - order2;
        });
    }
}
