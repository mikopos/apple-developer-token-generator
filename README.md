# apple-developer-token-generator

This project aims to automate the process of generating and signing apple developer tokens for Web apps, 
that are suppose to use apple's APIs. It does not save neither personal nor any private key
information in any type of storage (db, cache etc.). The application has been also deployed on heroku,
which uses an SSL encrypted connection to transmit the data, <strong>SO YOU CAN FEEL PRETTY SAFE</strong>,
using this application.


## Getting Started
These instructions below give you a brief description of how the project has been built, 
where to find it and which are the prerequisites steps you have to do before you use it.

### Prerequisites
* An Apple developer account
* An already existing private key for the API you want to use the  generated token

### URL
* [Apple developers token generator](https://apple-token-generator.web.app/)

## Built With
* [HTML](https://en.wikipedia.org/wiki/HTML) - Used to create the initial UI.
* [Springboot](https://en.wikipedia.org/wiki/Spring_Framework) - Used to create the backend layer.

## Deployed on
* [Firebase](https://firebase.google.com/)

## Contributing

Please read [CODE_OF_CONDUCT.md](https://github.com/mikopos/apple-developer-token-generator/blob/main/CODE_OF_CONDUCT.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning
The current version is v1.0.0 .

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/mikopos/apple-developer-token-generator/tags).

## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/mikopos/apple-developer-token-generator/blob/main/LICENSE) file for details

## Acknowledgments

* [Generating Developer Token](https://developer.apple.com/documentation/applemusicapi/generating_developer_tokens)
* [Colorlib](https://colorlib.com/wp/templates/)