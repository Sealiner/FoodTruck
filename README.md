# Introduction
This is a simple web application. It is so simple that it has only one function, searching food item.

Functional development is always endless, the introduction below will mainly focus on code, including architecture, design purpose and etc..

This application has two parts: a web frontend and a web API. 

# Web frontend
The web frontend is developed with React. In most cases, We can make a single-page-app to improve user experience. But in many times，we still need some independent pages to achieve certain purpose, for example, sharing a simple page to others, for faster page load, to meet the technical requirements of business partners and so on. So I made the web frontend adaptable for both single-page-app and independent pages by packaging files according to routes provided by file "routes.json". An ejs template is also used here to provide more flexibility to adjust pages as you know frontend product requirements are always changing fast in a highly active internet market in China.

A dev server is made here to convenient development and debugging. It uses express, a popular web framework with javascript. 

Run
```bash
$ npm install
$ npm run start
```
to start dev server in your local pc.

Run
```bash
$ npm run build-prod
```
to build for production.

In my opinion, js is more flexible and lightweight than many other languages when developing a webapi service. Nodejs has a good performance in high concurrency scenes. But for many cases, backend services are always very complex and have low tolerance for error. This is why I choose java to develop backend service(Of course, it's OK to use nodejs here anyway, you won't starve without this application^_^).


# Web API
The web API is developed with Java and the framework is Spring Boot. As written above, I choose java as backend develop language is not because it's better than js. To be honest, I prefer developing wiht js or python. But I have to admit that java is more strict and has more mature and good practiced cases in backend area. 

The web API service here is also very simple, no database, no interceptor, no paging, no monitor... I only wrote two apis here, one to return all data in the .cvs file and the other one to return data filtered by food item. 

Maven is used to build and deploy the service.

I usually use docker and k8s to deploy my services in production. You can see a dockerfile and some configurations in pom.xml(Because there is no docker service and registry in my new pc, I turned the related plugins off, but you can still see it).

# Deploy in production
To deploy in production, there's still some works to do. I usually use jenkins and gitlab to automatize the deployment of backend services. For web frontend, I ususally put the build files into the directory served by nginx.

# The end
It's interesting for me to know about food trucks in San Francisco. Bon appétit！





