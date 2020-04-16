Final task - Goals list

A final project task for Grid Dynamics testing school of fall-2018.


Getting Started

Prerequisites
Intellij IDEA
Maven


Installing
Download files from the repository and run Main .
The console-based interface will prompt the user for available actions

Built With
Intellij IDEA
Maven - Dependency Management

Authors
Shimansky Dmitry

Known issues

current issues  i haven't got time to resolve properply, but aware of
1 - methods for User and Goal List itself should be separated
2 - method specialCharacterValidation may work better with regex tools, but i haven't figured out how it works yet.
3 - boolean reached = false is not set in constructor, but hard-coded in method addNewGoal
4 - code is not fool-proof - no exceptions handling is implemented
5 - Goals IDs are not handling duplicates whatsoever
6- setting reached/Not reached is done with too much of coding, basically duplicating updateGoal method
7 - incorrect location of method specialCharacterValidation- should be in Goals, but had access issues
8 - User parameters should be included in parameters file instead of being hard-coded
9 - some validation is hard-coded, which could be done with primitives (however, those occasions are single ones)
10- Junit test on specialCharacterValidation is done in awkward way, had issues with access modifiers.
11 - Junit tests for console input method are not done at all.
As far as I understood, this requires Mocks and I have no experience with them at the moment.


Acknowledgments
Grid testing school lecturers - Evgeny Lozovan, Andrew Guitelson, Lilia Urmazova, Pavel Vlaskin, Anton Polozhiy, Vera Matveeva, Anastasia Chuprova
Tim Buchalka and his Java Masterclass
Javarush
Grid testing school mates


