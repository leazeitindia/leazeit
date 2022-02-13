package in.leazeit.service;

import in.leazeit.entity.Subscription;

import java.util.List;


public interface SubscriptionService {
    List<Subscription> getAllEmailSubscribers();
    Subscription addEmailSubscriber(Subscription subscriptionRequest);
}
