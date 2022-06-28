package main.java.task2;//You are given a list of cities.
// Each direct connection between two cities has its transportation cost (an integer bigger than 0).
// The goal is to find the paths of minimum cost between pairs of cities.
// Assume that the cost of each path
// (which is the sum of costs of all direct connections belonging to this path) is at most 200000.
// The name of a city is a string containing characters a,...,z and is at most 10 characters long.2)

//Input
//s -           [the number of tests <= 10]
//n -           [the number of cities <= 10000]
//NAME -        [city name]
//p -           [the number of neighbors of city NAME]
//nr cost -     [nr - index of a city connected to NAME (the index of the first city is 1)]
//              [cost - the transportation cost]
//r -           [the number of paths to find <= 100]
//NAME1 NAME2 - [NAME1 - source, NAME2 - destination]
//              [empty line separating the tests]


import static java.lang.Math.min;
import static java.util.Arrays.fill;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskTwo {

    private static final int NUMBER_OF_CITIES = 10000;

    public static void main(String[] args) throws IOException {
        File path = new File("test_data.txt");
        BufferedReader br = new BufferedReader(new FileReader(path.getAbsolutePath()));
        String line = br.readLine();
        int source = Integer.parseInt(line);

        for (int testIndex = 0; testIndex < source; testIndex++) {
            String[] citiesInd = new String[NUMBER_OF_CITIES];
            line = br.readLine();
            int countCities = Integer.parseInt(line);
            int matrixSize = countCities + 1;
            Matrix matrix = new Matrix(matrixSize);

            for (int cityIndex = 0; cityIndex < countCities; cityIndex++) {
                line = br.readLine();
                String cityName = line;
                citiesInd[cityIndex] = cityName;
                line = br.readLine();
                int p = Integer.parseInt(line);

                for (int neighborIndex = 0; neighborIndex < p; neighborIndex++) {
                    line = br.readLine();
                    String[] brokenLine = line.split(" ");
                    int cityToConnect = Integer.parseInt(brokenLine[0]);
                    int weightOfConnection = Integer.parseInt(brokenLine[1]);
                    matrix.setEdge(cityIndex, cityToConnect, weightOfConnection);
                }
            }
            line = br.readLine();
            int routesToFind = Integer.parseInt(line);
            for (int routesIndex = 0; routesIndex < routesToFind; routesIndex++) {
                line = br.readLine();
                String[] cityNames = line.split(" ");
                String start = cityNames[0];
                String destination = cityNames[1];
                List<String> list = new ArrayList<>();

                for (String s : citiesInd) {
                    if (s != null) {
                        list.add(s);
                    }
                }

                citiesInd = list.toArray(new String[0]);
                int startIndex = 0;
                int destinationIndex = 0;
                // find the index of the initial city
                for (int i = 0; i < citiesInd.length; i++)
                    if (start.equals(citiesInd[i])) {
                        startIndex = i;
                        break;
                    }
                // find the index of the end of the city
                for (int i = 0; i < citiesInd.length; i++) {
                    if (destination.equals(citiesInd[i])) {
                        destinationIndex = i;
                        break;
                    }
                }
                Integer[] distancesFromSource = matrix.waysOfMinimumCostBetweenPairsOfCities(startIndex);
                int destinationDistance = distancesFromSource[destinationIndex];
                System.out.println(destinationDistance);
            }
        }
        br.close();
    }
}

