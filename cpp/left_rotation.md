Array Left Rotation;


比较直接的办法是new index 取module

```
vector<int> array_left_rotation(vector<int> a, int n, int k) {
    vector<int> b(n);
    for (int i = 0; i < n; i++) {
        int new_index = (i + n - k) % n;
        b[new_index] = a[i];
    }
    return b;
}
```

```
vector<int> array_left_rotation(vector<int> a, int n, int k) {
    auto n_first = a.begin() + k;
    auto next = n_first;
    auto first = a.begin();
    while(first != next) {
        std::iter_swap(first++, next++);
        if (next == a.end()){
            next = n_first;
        } else if(first == n_first) {
            n_first = next;
        }
    }
    return a;
}
```