# Spring Security Issue

This repository contains a very basic example that shows an issue with Spring Security when trying to set Cache-Control headers in an async DeferredResult response. The value is being set correctly, but the default caching security headers are being added earlier without taking into consideration that the async request might want to customize Cache-Control on demand.

Issue link: https://github.com/spring-projects/spring-security/issues/12865
