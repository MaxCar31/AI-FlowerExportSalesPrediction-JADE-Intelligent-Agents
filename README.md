# AI Flower Sales Predictor with JADE

## Description
This project implements an agent-based system to predict future sales for the XYZ Flower Export Company using Genetic Algorithms (AG). The aim is to monitor a client's sales to maximize economic return over the next 20 weeks.

## Project Structure
The project is structured around several agents interacting with each other to make predictions and sales decisions based on these forecasts. The involved agents are:

- **AH1**: Maximizes an objective function using a genetic algorithm.
- **AG1**: Passes the maximum value found by AH1 to AG2.
- **AG2**: Decides whether to proceed with the sale based on the value received from AG1.
- **AG3**: Acts according to the instructions from AG2 and AG4 to carry out or stop the sale.
- **AG4**: Evaluates the client's debt and advises on the sale.

## Technologies Used
- **Java**: The main programming language.
- **JADE (Java Agent Development Framework)**: Used for implementing and managing agents.

## Getting Started

### Prerequisites
- Java JDK 8 or higher.
- JADE Framework.

### Installation and Execution
1. Clone the repository to your local machine:

 ## Installation

Clone the repository using:

```bash
git clone https://github.com/MaxCar31/AI-FlowerExportSalesPrediction-JADE-Intelligent-Agents
```
## License
This project is licensed under the MIT License - see the `LICENSE.md` file for details.

## Acknowledgments
- Special thanks to Ing. Henry Paz Arias MSc. for the guidance and support in developing this project.

