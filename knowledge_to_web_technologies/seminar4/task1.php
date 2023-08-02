<?php
// Формируем массив с опытом работы
$jobs = [
    [
        'name' => 'GB',
        'data' => '2022-настоящее время',
        'desc' => 'Много интересной работы',
    ],
    [
        'name' => 'Бэттери Тим',
        'data' => '2000-2006',
        'desc' => 'Разная работа',
    ],
    [
        'name' => 'Студия Лебедева',
        'data' => '1999-2000',
        'desc' => 'Очень много креативной работы',
    ],
];
?>

<div class="w3-container w3-card w3-white w3-margin-bottom">
    <h2 class="w3-text-grey w3-padding-16">
        <i class="fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Опыт работы
    </h2>
    <?php foreach ($jobs as $job): ?>
        <div class="w3-container">
            <h5 class="w3-opacity"><b><?= $job['name']; ?></b></h5>
            <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right"></i><?= $job['data']; ?></h6>
            <p><?= $job['desc']; ?></p>
            <hr>
        </div>
    <?php endforeach; ?>
</div>
