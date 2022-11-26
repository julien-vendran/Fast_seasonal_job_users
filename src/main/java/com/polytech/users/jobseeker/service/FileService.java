package com.polytech.users.jobseeker.service;

import com.polytech.users.jobseeker.entity.FilesEntity;
import com.polytech.users.jobseeker.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    public FilesEntity save(MultipartFile file) throws IOException {
        FilesEntity fileEntity = new FilesEntity();
        fileEntity.setName(StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename())));
        fileEntity.setContentType(file.getContentType());
        fileEntity.setData(file.getBytes());
        fileEntity.setSize(file.getSize());

        return fileRepository.save(fileEntity);
    }

    public Optional<FilesEntity> getFile(Long id) {
        return fileRepository.findById(id);
    }
}
