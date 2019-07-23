Unique implementation of a Binary Search Tree.

I did not used the all around foundable solution - the creating new lists when calling the recursive function.
Instead I'm creating a List from the input List and reordering how the recursive adding function should logically work.
The tree is always flattened. The adding and removing function always recreating the whole tree in this version.

The user can create BST from ordered and unordered lists. The unordered lists goes through my implementation of Quicsort.
