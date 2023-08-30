% Пустой список
sum_list([], 0).

% Сумма списка != 0
sum_list([Head | Tail], Sum) :-
    sum_list(Tail, TailSum),
    Sum is Head + TailSum.
