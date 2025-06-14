//
//  FlowPublisher.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 20.05.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Combine
import shared
import Foundation
//
//struct FlowPublisher<T: Any> : Publisher {
//
//    typealias Output = T
//    typealias Failure = Never
//    private let flow: Kotlinx_coroutines_coreFlow
//
//
//    init (flow: Kotlinx_coroutines_coreFlow) {
//        self.flow = flow
//    }
//
//    func receive<S: Subscriber>(subscriber: S) where S.Input == T, S.Failure == Failure {
//        subscriber.receive(subscription: FlowSubscription(flow: flow, subscriber: subscriber))
//    }
//
//    final class FlowSubscription<S: Subscriber>: Subscription where S.Input == T, S.Failure == Failure {
//        private var subscriber: S?
//        private var job: Kotlinx_coroutines_coreJob?
//        private let flow: Kotlinx_coroutines_coreFlow
//
//        init(flow: Kotlinx_coroutines_coreFlow, subscriber: S) {
//            self.flow = flow
//            self.subscriber = subscriber
//        }
//        func request (_ demand: Combine.Subscribers.Demand) {
//            guard let subscriber = subscriber else { return }
//
//
//            job = FlowKt.subscribe(
//                flow,
//                onEach: { item in if let item = item as? T { _ = subscriber.receive(item)} },
//                onComplete: { subscriber.receive(completion: .finished) },
//                onThrow: { error in debugPrint(error) }
//            )
//        }
//        func cancel() {
//            subscriber = nil
//            job?.cancel(cause: nil)
//        }
//    }
//}
//
//public extension Kotlinx_coroutines_coreFlow {
//    func asPublisher<T: AnyObject>() -> AnyPublisher<T, Never> {
//        (FlowPublisher(flow: self) as FlowPublisher<T>).eraseToAnyPublisher()
//    }
//}
//commonPublisherFlow
func commonPublisherFlow<T>(_ flow: CommonFlow<T>) -> AnyPublisher<T, Never> {
    return Deferred<Publishers.HandleEvents<PassthroughSubject<T, Never>>> {
        let subject = PassthroughSubject<T, Never>()
        let closeable = flow.watch { next in
            guard let next else {
                return
            }
            subject.send(next)
        }

        return subject.handleEvents(receiveCancel: {
            closeable.close()
        })
    }.eraseToAnyPublisher()
}
//commonStatePublisherFlow
func commonStatePublisherFlow<T>(_ flow: CommonStateFlow<T>) -> AnyPublisher<T, Never> {
    return Deferred {
        let subject = PassthroughSubject<T, Never>()
        let closeable = flow.watch { next in
            subject.send(next)
        }

        return subject.handleEvents(receiveCancel: {
            closeable.close()
        })
    }
    .eraseToAnyPublisher()
}

public extension Kotlinx_coroutines_coreFlow {

}
